val problemConditions = List(
// The Englishmen lives in the red house.
	Condition(
		"The Englishmen lives in the red house",
		Trait.Nationality,
		Nationality.English,
		ConditionType.SameHouseAs,
		Trait.HouseColor,
		HouseColor.Red
	),
// The Spaniard owns the dog.
	Condition(
		"The Spaniard owns the dog.",
		Trait.Nationality,
		Nationality.Spanish,
		ConditionType.SameHouseAs,
		Trait.Pet,
		Pet.Dog
	),
// Coffee is drunk in the green house.
	Condition(
		"Coffee is drunk in the green house.",
		Trait.Drink,
		Drink.Coffee,
		ConditionType.SameHouseAs,
		Trait.HouseColor,
		HouseColor.Green
	),
// The Ukrainian drinks tea.
	Condition(
		"The Ukrainian drinks tea.",
		Trait.Nationality,
		Nationality.Ukrainian,
		ConditionType.SameHouseAs,
		Trait.Drink,
		Drink.Tea
	),
// The green house is immediately to the right (your right) of the ivory house.
	Condition(
		"The green house is immediately to the right (your right) of the ivory house.",
		Trait.HouseColor,
		HouseColor.Green,
		ConditionType.RightOf,
		Trait.HouseColor,
		HouseColor.Ivory
	),
// The Old Gold smoker owns snails.
	Condition(
		"The Old Gold smoker owns snails.",
		Trait.Cigarettes,
		Cigarettes.OldGold,
		ConditionType.SameHouseAs,
		Trait.Pet,
		Pet.Snail
	),
// Kools are smoked in the yellow house.
	Condition(
		"Kools are smoked in the yellow house.",
		Trait.Cigarettes,
		Cigarettes.Kools,
		ConditionType.SameHouseAs,
		Trait.HouseColor,
		HouseColor.Yellow
	),
// Milk is drunk in the middle house.
	Condition(
		"Milk is drunk in the middle house.",
		Trait.Drink,
		Drink.Milk,
		ConditionType.SameHouseAs,
		Trait.Position,
		Position.Middle
	),
// The Norwegian lives in the first house on the left.
	Condition(
		"The Norwegian lives in the first house on the left.",
		Trait.Position,
		Position.FarLeft,
		ConditionType.SameHouseAs,
		Trait.Nationality,
		Nationality.Norwegian
	),
// The man who smokes Chesterfields lives in the house next to the man with the fox.
	Condition(
		"The man who smokes Chesterfields lives in the house next to the man with the fox.",
		Trait.Cigarettes,
		Cigarettes.Chesterfileds,
		ConditionType.NextTo,
		Trait.Pet,
		Pet.Fox
	),
// Kools are smoked in the house next to the house where the horse is kept.
	Condition(
		"Kools are smoked in the house next to the house where the horse is kept.",
		Trait.Cigarettes,
		Cigarettes.Kools,
		ConditionType.NextTo,
		Trait.Pet,
		Pet.Horse
	),
// The Lucky Strike smoker drinks orange juice.
	Condition(
		"The Lucky Strike smoker drinks orange juice.",
		Trait.Cigarettes,
		Cigarettes.LuckyStrike,
		ConditionType.SameHouseAs,
		Trait.Drink,
		Drink.OrangeJuice
	),
// The Japanese man smokes Parliaments.
	Condition(
		"The Japanese man smokes Parliaments.",
		Trait.Nationality,
		Nationality.Japanese,
		ConditionType.SameHouseAs,
		Trait.Cigarettes,
		Cigarettes.Parliaments,
	),
// The Norwegian lives next to the blue house.
	Condition(
		"The Norwegian lives next to the blue house.",
		Trait.Nationality,
		Nationality.Norwegian,
		ConditionType.NextTo,
		Trait.HouseColor,
		HouseColor.Blue
	),
)