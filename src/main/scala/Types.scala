
sealed trait Checkable

sealed trait Trait
object Trait {
	case object Position extends Trait
	case object HouseColor extends Trait
	case object Nationality extends Trait
	case object Pet extends Trait
	case object Drink extends Trait
	case object Cigarettes extends Trait
}

sealed trait Position extends Checkable {
  def right: Option[Position]
  def left: Option[Position]
}
object Position {
  case object FarLeft extends Position {
    def right = Some(Left)
    def left = None
  }
  case object Left extends Position {
    def right = Some(Middle)
    def left = Some(Left)
  }
  case object Middle extends Position {
    def right = Some(Right)
    def left = Some(Left)
  }
  case object Right extends Position {
    def right = Some(FarRight)
    def left = Some(Middle)
  }
  case object FarRight extends Position {
    def right = None
    def left = Some(Right)
  }
}

sealed trait HouseColor extends Checkable
object HouseColor {
  case object Yellow extends HouseColor
  case object Blue extends HouseColor
  case object Red extends HouseColor
  case object Ivory extends HouseColor
  case object Green extends HouseColor
}

sealed trait Nationality extends Checkable
object Nationality {
  case object Norwegian extends Nationality
  case object Ukrainian extends Nationality
  case object English extends Nationality
  case object Spanish extends Nationality
  case object Japanese extends Nationality
}

sealed trait Pet extends Checkable
object Pet {
  case object Fox extends Pet
  case object Horse extends Pet
  case object Snail extends Pet
  case object Dog extends Pet
  case object Zebra extends Pet
}

sealed trait Drink extends Checkable
object Drink {
  case object Water extends Drink
  case object Tea extends Drink
  case object Milk extends Drink
  case object OrangeJuice extends Drink
  case object Coffee extends Drink
}

sealed trait Cigarettes extends Checkable
object Cigarettes {
  case object Kools extends Cigarettes
  case object Chesterfileds extends Cigarettes
  case object OldGold extends Cigarettes
  case object LuckyStrike extends Cigarettes
  case object Parliaments extends Cigarettes
}