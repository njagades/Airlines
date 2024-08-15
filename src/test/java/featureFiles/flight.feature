Feature: Validate QAClickJet landing page
@Auto_Suggestive
    Scenario: validate the auto suggestive dropdown
    Given User is on the QAClickJet landing Page
    When enter the country name partially<"ind">
    And the user select the country name
    Then the selected country should be displayed in the field.
@Check_box    
    Scenario: validate the check box
    Given User is on the QAClickJet landing Page
    When the user click  the check box  
    Then the UI should change accordingly.
    
    #Scenario: validate the passengers dropdown
    #Given User is on the QAClickJet landing Page
    #When the user open passengers dropdown and adds 3 adults
    #And the user clicks on the Done button
    #Then the number of added adults should be displayed in the passengers filed.
   
@Static_dropdown
    Scenario: validate the currency dropdown
    Given User is on the QAClickJet landing Page
    When the user open currency dropdown and select the currency
    Then the selected currency should be displayed in the currency filed.
    
    
  
    
      
  