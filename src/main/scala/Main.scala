@main def hello: Unit = 
  println(testState.toString)
  println(testState.checkConditions(problemConditions))


class HouseState (
  position: Position,
  houseColor: HouseColor,
  nationality: Nationality,
  pet: Pet,
  drink: Drink,
  cigarettes: Cigarettes
) {
  def checkConditions(conditions: List[Condition]): Boolean = {
    conditions.foldLeft(true)((acc, condition) => acc && 
      (
        !checkCheckable(condition.subTrait, condition.sub) || 
        checkCheckable(condition.objTrait, condition.obj)
      )
    )
  }

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
    houseStates.values.foldLeft(true)((acc, state) => acc && state.checkConditions(conditions))

  override def toString = 
    houseStates.values.mkString
  
}

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