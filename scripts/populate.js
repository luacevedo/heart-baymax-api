db.grantRolesToUser( "heroku_1hl7j974", [ { role: "read", db: "test1" } ] );
db.stepstest02.drop();
db.stepstest02.insert(
{
  step: 1,
  inputFields: [
    {
      id: "1",
      labelMessage: "Presenta edema pulmonar?",
      rootToAffect: "EssentialSymptoms.PulmonaryEdema",
      dataType: "boolean",
      fieldType: "combobox",
      values: [
        {
          key: "0",
          value: "No"
        },
        {
          key: "1",
          value: "Si"
        }
      ]
    },
    {
      id: "2",
      labelMessage: "Presenta ortopnea?",
      rootToAffect: "EssentialSymptoms.Orthopnoea",
      dataType: "boolean",
      fieldType: "combobox",
      values: [
        {
          key: "0",
          value: "No"
        },
        {
          key: "1",
          value: "Si"
        }
      ]
    }
  ]
}
);

db.stepstest02.insert(
{
  step: 2,
  inputFields: [
    {
      id: "3",
      labelMessage: "Presenta disnea?",
      rootToAffect: "EssentialSymptoms.Dyspnoea",
      dataType: "boolean",
      fieldType: "combobox",
      values: [
        {
          key: "0",
          value: "No"
        },
        {
          key: "1",
          value: "Si"
        }
      ]
    }
  ]
}
);


