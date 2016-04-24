package mock

import models.{Action, Condition, Rule, RulesResource}

object MockRules {
  def getMockedRules: RulesResource = {

    def getPulmonaryEdemaRule: Rule = {
      val conditions = List(Condition("affirmative", "EssentialSymptoms.PulmonaryEdema", None))
      val actions = List(Action("addNumber", "InitialPhysicalState.EssentialSymptomsAssessment", "3"), Action("addToList", "InitialPhysicalState.EssentialSymptoms", "PulmonaryEdema"))
      Rule(1, conditions, actions, Nil)
    }

    def getDyspnoeaRule = {
      val conditions = List(Condition("affirmative", "EssentialSymptoms.Dyspnoea", None))
      val actions = List(Action("addNumber", "InitialPhysicalState.EssentialSymptomsAssessment", "3"), Action("addToList", "InitialPhysicalState.EssentialSymptoms", "Dyspnoea"))
      Rule(2, conditions, actions, Nil)
    }

    def getOrthopnoeaRule = {
      val conditions = List(Condition("affirmative", "EssentialSymptoms.Orthopnoea", None))
      val actions = List(Action("addNumber", "InitialPhysicalState.EssentialSymptomsAssessment", "2"), Action("addToList", "InitialPhysicalState.EssentialSymptoms", "Orthopnoea"))
      Rule(3, conditions, actions, Nil)
    }

    def getRule4 = {
      val conditions = List(Condition("greaterThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("4")), Condition("contains", "InitialPhysicalState.EssentialSymptoms", Some("PulmonaryEdema")))
      val actions = List(Action("assign", "PreliminaryDiagnosis.SymptomsType", "Urgent"))
      Rule(4, conditions, actions, List(5,6,7,8))
    }

    def getRule5 = {
      val conditions = List(Condition("greaterThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("4")), Condition("notContains", "InitialPhysicalState.EssentialSymptoms", Some("PulmonaryEdema")))
      val actions = List(Action("assign", "PreliminaryDiagnosis.SymptomsType", "Moderate"))
      Rule(5, conditions, actions, List(6,7,8))
    }

    def getRule6 = {
      val conditions = List(Condition("lessThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("4")),
        Condition("greaterThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("0")),
        Condition("contains", "InitialPhysicalState.EssentialSymptoms", Some("PulmonaryEdema")))
      val actions = List(Action("assign", "PreliminaryDiagnosis.SymptomsType", "Moderate"))
      Rule(6, conditions, actions, List(7,8))
    }

    def getRule7 = {
      val conditions = List(Condition("lessThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("4")),
        Condition("greaterThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("0")),
        Condition("notContains", "InitialPhysicalState.EssentialSymptoms", Some("PulmonaryEdema")))
      val actions = List(Action("assign", "PreliminaryDiagnosis.SymptomsType", "Scarce"))
      Rule(7, conditions, actions, List(8))
    }

    def getRule8 = {
      val conditions = List(Condition("lessThan", "InitialPhysicalState.EssentialSymptomsAssessment", Some("1")))
      val actions = List(Action("assign", "PreliminaryDiagnosis.SymptomsType", "None"))
      Rule(8, conditions, actions, Nil)
    }

    RulesResource(List(
      getPulmonaryEdemaRule, getDyspnoeaRule, getOrthopnoeaRule, getRule4, getRule5, getRule6, getRule7, getRule8
    ))

  }
}
