
@main def checkAllPerms: Unit = 
  // println(testState.toString)
  // println(testState.checkConditions(problemConditions))
  // // print failing conditions
  // println(
  //   problemConditions
  //     .filter(!testState.checkSingleCondition(_))
  //     .map(_.name + '\n')
  //     .mkString
  // )

  var houseColors = HouseColor.allPossible
  for (houseColors <- HouseColor.allPossible.permutations) {
    for (nationalities <- Nationality.allPossible.permutations) {
      for (pets <- Pet.allPossible.permutations) {
        for (drinks <- Drink.allPossible.permutations) {
          for (cigarettes <- Cigarettes.allPossible.permutations) {
            var stateMap: Map[Position, HouseState] = Map();
            var positions = Position.allPossible
            var x: Int = 0;
            for (x <- 0 to Position.allPossible.size - 1) {
              stateMap += (positions(x) -> HouseState(
                positions(x),
                houseColors(x),
                nationalities(x),
                pets(x),
                drinks(x),
                cigarettes(x)
              ))
            }
            val cityState = CityState(stateMap)
            if (cityState.checkConditions(problemConditions)) {
              println(cityState.toString)
              println()
            }
          }
        }
      }
    }
  }


class HouseState (
  position: Position,
  houseColor: HouseColor,
  nationality: Nationality,
  pet: Pet,
  drink: Drink,
  cigarettes: Cigarettes
) {
  def checkCheckable(t: Trait, checkable: Checkable): Boolean = {
    t match {
      case Trait.Position => position == checkable
      case Trait.HouseColor => houseColor == checkable
      case Trait.Nationality => nationality == checkable
      case Trait.Pet => pet == checkable
      case Trait.Drink => drink == checkable
      case Trait.Cigarettes => cigarettes == checkable
    }
  }
  override def toString = s"$position | $houseColor | $nationality | $pet | $drink | $cigarettes \n"
}

class CityState (
  houseStates: Map[Position, HouseState]
) {
  def checkConditions(conditions: List[Condition]) =
    // check all conditions one by one
    andFold(conditions.map(checkSingleCondition(_)))

  def checkSingleCondition(condition: Condition): Boolean = {
    houseStates
    // get all house states that satisfy the first condition (in this case is always exactly one)
      .filter(_._2.checkCheckable(condition.subTrait, condition.sub))
      // check the second half of the condition
      .map((pos, houseState) =>
        condition
        .conditionType
        // get the positions to check the second half of the condition on
        .positionsToCheck(pos)
        // for Some(_) check if they satisfy the second half of the condition
        .map(
          // get all candidates for second half of condition
          houseStates
          .get(_)
          // check them for second half
          .map(_.checkCheckable(condition.objTrait, condition.obj))
          // make sure the condition was satisfied somewhere
        ).exists(option => option.isDefined && option.get)
      ).exists(_ == true)
  }

  override def toString = 
    houseStates.values.mkString
  
}


def orFold(list: List[Boolean]): Boolean = list.foldLeft(false)((acc, b) => b || acc)
def andFold(list: List[Boolean]): Boolean = list.foldLeft(true)((acc, b) => b && acc)


val testState = CityState(
    Map(
      (Position.FarLeft, HouseState(
        Position.FarLeft,
        HouseColor.Yellow,
        Nationality.Norwegian,
        Pet.Fox,
        Drink.Water,
        Cigarettes.Kools
      )),
      (Position.Left, HouseState(
        Position.Left,
        HouseColor.Blue,
        Nationality.Ukrainian,
        Pet.Horse,
        Drink.Tea,
        Cigarettes.Chesterfileds
      )),
      (Position.Middle, HouseState(
        Position.Middle,
        HouseColor.Red,
        Nationality.English,
        Pet.Snail,
        Drink.Milk,
        Cigarettes.OldGold
      )),
      (Position.Right, HouseState(
        Position.Right,
        HouseColor.Ivory,
        Nationality.Spanish,
        Pet.Dog,
        Drink.OrangeJuice,
        Cigarettes.LuckyStrike
      )),
      (Position.FarRight, HouseState(
        Position.FarRight,
        HouseColor.Green,
        Nationality.Japanese,
        Pet.Zebra,
        Drink.Coffee,
        Cigarettes.Parliaments
      ))
    )
  )