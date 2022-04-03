
sealed trait ConditionType {
	def positionsToCheck(position: Position): List[Position]
}

object ConditionType {
	case object SameHouseAs extends ConditionType {
		def positionsToCheck(position: Position) = List(position)
	}

	case object LeftOf extends ConditionType {
		def positionsToCheck(position: Position) =
			position.right.toList
	}
	case object RightOf extends ConditionType {
		def positionsToCheck(position: Position) =
			position.left.toList
	}
	case object NextTo extends ConditionType {
		def positionsToCheck(position: Position) =
			position.left.toList ++ position.right.toList
	}
}

class Condition(
	val name: String,
	val subTrait: Trait,
	val sub: Checkable,
	val conditionType: ConditionType,
	val objTrait: Trait,
	val obj: Checkable
)