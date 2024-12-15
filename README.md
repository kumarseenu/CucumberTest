# Cucumber-BDD

# Execute Without TestNg
mvn clean test
# Execute Using TestNg
mvn clean test -DsuiteXmlFile=testng.xml

# Generate Allure report
allure serve allure-results