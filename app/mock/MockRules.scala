package mock

import models._

object MockRules {
  def getMockedRules: RulesResponse = {

    def getPulmonaryEdemaRule = {
      val conditions = List(Condition(1, "affirmative", "EssentialSymptoms.PulmonaryEdema", None, 1))
      val actions = List(Action(1, "addNumber", "InitialPhysicalState.EssentialSymptomsAssessment", "3", 1), Action(2, "addToList", "InitialPhysicalState.EssentialSymptoms", "PulmonaryEdema", 1))
      RuleResource(1, conditions, actions, Nil)
    }

    def getDyspnoeaRule = {
      val conditions = List(Condition(2, "affirmative", "EssentialSymptoms.Dyspnoea", None, 2))
      val actions = List(Action(3, "addNumber", "InitialPhysicalState.EssentialSymptomsAssessment", "3", 2), Action(4, "addToList", "InitialPhysicalState.EssentialSymptoms", "Dyspnoea", 2))
      RuleResource(2, conditions, actions, Nil)
    }

    def getOrthopnoeaRule = {
      val conditions = List(Condition(3, "affirmative", "EssentialSymptoms.Orthopnoea", None, 3))
      val actions = List(Action(5, "addNumber", "InitialPhysicalState.EssentialSymptomsAssessment", "2", 3), Action(6, "addToList", "InitialPhysicalState.EssentialSymptoms", "Orthopnoea", 3))
      RuleResource(3, conditions, actions, Nil)
    }

    def getRule4 = {
      val conditions = List(Condition(4, "greaterThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("4"), 4), Condition(5, "contains", "InitialPhysicalState.EssentialSymptoms", Some("PulmonaryEdema"), 4))
      val actions = List(Action(7, "assign", "PreliminaryDiagnosis.SymptomsType", "Urgent", 4))
      RuleResource(4, conditions, actions, List(RuleToExclude(5, 4), RuleToExclude(6, 4), RuleToExclude(7, 4), RuleToExclude(8, 4)))
    }

    def getRule5 = {
      val conditions = List(Condition(6, "greaterThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("4"), 5), Condition(7, "notContains", "InitialPhysicalState.EssentialSymptoms", Some("PulmonaryEdema"), 5))
      val actions = List(Action(8, "assign", "PreliminaryDiagnosis.SymptomsType", "Moderate", 5))
      RuleResource(5, conditions, actions, List(RuleToExclude(6, 5), RuleToExclude(7, 5), RuleToExclude(8, 5)))
    }

    def getRule6 = {
      val conditions = List(Condition(8, "lessThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("4"), 6),
        Condition(9, "greaterThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("0"), 6),
        Condition(10, "contains", "InitialPhysicalState.EssentialSymptoms", Some("PulmonaryEdema"), 6))
      val actions = List(Action(9, "assign", "PreliminaryDiagnosis.SymptomsType", "Moderate", 6))
      RuleResource(6, conditions, actions, List(RuleToExclude(7, 6), RuleToExclude(8, 6)))
    }

    def getRule7 = {
      val conditions = List(Condition(11, "lessThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("4"), 7),
        Condition(12, "greaterThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("0"), 7),
        Condition(13, "notContains", "InitialPhysicalState.EssentialSymptoms", Some("PulmonaryEdema"), 7))
      val actions = List(Action(10, "assign", "PreliminaryDiagnosis.SymptomsType", "Scarce", 7))
      RuleResource(7, conditions, actions, List(RuleToExclude(8, 7)))
    }

    def getRule8 = {
      val conditions = List(Condition(14, "lessThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("1"), 8))
      val actions = List(Action(11, "assign", "PreliminaryDiagnosis.SymptomsType", "None", 8))
      RuleResource(8, conditions, actions, Nil)
    }

    RulesResponse(List(
      getPulmonaryEdemaRule, getDyspnoeaRule, getOrthopnoeaRule, getRule4, getRule5, getRule6, getRule7, getRule8
    ))

  }
}
