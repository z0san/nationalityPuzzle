
sealed trait ConditionType {
	def positionsToCheck(position: Position): Option[List[Position]]
}

object ConditionType {
	case object SameHouseAs extends ConditionType {
		def positionsToCheck(position: Position) = Some(List(position))
	}

	case object LeftOf extends ConditionType {
		def positionsToCheck(position: Position) =
			position.left.map(List(_))
	}
	case object RightOf extends ConditionType {
		def positionsToCheck(position: Position) =
			position.right.map(List(_))
	}
	case object NextTo extends ConditionType {
		def positionsToCheck(position: Position) =
			(position.right, position.left) match {
				case (Some(l), Some(r)) => Some(List(l, r))
				case _ => None
			}
	}
}

class Condition(
	val subTrait: Trait,
	val sub: Checkable,
	val conditionType: ConditionType,
	val objTrait: Trait,
	val obj: Checkable
)