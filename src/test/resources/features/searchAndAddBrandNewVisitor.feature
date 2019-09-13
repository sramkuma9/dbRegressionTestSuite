#Feature: Add and search brand new visitor
#
#  Scenario: Add a brand new Visitor
#    Given User navigates to BNI homepage
#    When I enter a valid existing email id and click search and create new button and I enter the below details and click the save button and search the added visitor
#         |chapter|      |region|     |firstName| |lastName|      |profession|               |speciality|         |person|  |visitDay|  |visitMonth|  |visitYear|   |title| |companyName|     |country|       |phone|
#         |Ant - One - Chapter A| |Ant - One| |Selenium| |Test+v||Information Technology|    |Information Technology|      |BNI|     |12|         |Aug|         |2019|      |Mr|   |Airtel|       |Antarctica |  |123456789|
#         |Ant - One - Chapter A|  |Ant - One||Selenium| |Test+v||Information Technology|    |Information Technology|      |BNI|     |12|         |Aug|         |2019|      |Mr|    |Airtel|       |Antarctica |  |123456789|
#    Then brand new visitor details saved successfully
#    And sign out from BNI