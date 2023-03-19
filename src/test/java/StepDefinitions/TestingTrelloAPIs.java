package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestingTrelloAPIs {

    public String baseUrl = "https://api.trello.com";
    public String token = "ATTA8eeec431ff2ead3ff3a767b29837031105cb94034756cd77daf537230f19fffdB9E611F1";
    public String key = "6477411736c06486e4bc9b51a0eeac9f";
    public String orgName = "omar1";
    private String orgID;
    public String testingBoard = "notest1";
    private String testingBoardID;
    public String startTestingList = "Testing1";
    private String startTestingListID;
    public void setOrgID(String orgID) {
        this.orgID = orgID;
    }

    public void setTestingBoardID(String testingBoardID) {
        this.testingBoardID = testingBoardID;
    }

    public void setStartTestingListID(String startTestingListID) {
        this.startTestingListID = startTestingListID;
    }

    public String getOrgID() {
        return orgID;
    }

    public String getTestingBoardID() {
        return testingBoardID;
    }

    public String getStartTestingListID() {
        return startTestingListID;
    }

    @When("Create an Organization")
    public void when() throws InterruptedException {
        RestAssured.baseURI= "https://api.trello.com/1/organizations";

        RequestSpecification req = RestAssured.given();

        req.queryParam("displayName", orgName).queryParam("key", key ).queryParam("token", token);

        req.header("Content-Type","application/json");

        Response response =req.post();
        response.prettyPrint();

        JsonPath path = response.jsonPath();
        String ID = path.getString("id");
        System.out.println(ID);
        setOrgID(ID);

        Thread.sleep(10000);
    }
    @And("get an organization for a member")
    public void getorg() throws InterruptedException {

        RestAssured.baseURI= "https://api.trello.com/1/members/me";

        RequestSpecification req = RestAssured.given();

        req.queryParam("key", key ).queryParam("token", token);

        req.header("Content-Type","application/json");

        Response response =req.get();
        response.prettyPrint();


        Thread.sleep(10000);
    }

    @And("create a new board")
    public void createBoard() throws InterruptedException {
        RestAssured.baseURI= "https://api.trello.com/1/boards/";

        RequestSpecification req = RestAssured.given();

        req.queryParam("name", testingBoard).queryParam("key", key ).queryParam("token", token).queryParam("idOrganization ",getOrgID());

        req.header("Content-Type","application/json");

        Response response =req.post();
        response.prettyPrint();

        JsonPath path = response.jsonPath();
        String ID = path.getString("id");
        System.out.println(ID);
        System.out.println(getOrgID());
        setTestingBoardID(ID);

        Thread.sleep(10000);
    }
    @And("get a board")
    public void getBoard() throws InterruptedException {

        RestAssured.baseURI= "https://api.trello.com/1/organizations/"+orgID+"/boards";

        RequestSpecification req = RestAssured.given();

        req.queryParam("key", key ).queryParam("token", token);

        req.header("Content-Type","application/json");

        Response response =req.get();
        response.prettyPrint();

        System.out.println(RestAssured.baseURI);


        Thread.sleep(10000);

    }

    @And("create a new list")
    public void createList() throws InterruptedException {
        RestAssured.baseURI= "https://api.trello.com/1/lists";

        RequestSpecification req = RestAssured.given();

        req.queryParam("name", startTestingList).queryParam("idBoard", getTestingBoardID()).queryParam("key", key ).queryParam("token", token).queryParam("idOrganization ", getOrgID());

        req.header("Content-Type","application/json");

        Response response =req.post();
        response.prettyPrint();

        JsonPath path = response.jsonPath();
        String ID = path.getString("id");
        System.out.println(ID);
        setStartTestingListID(ID);
        Thread.sleep(10000);
    }
    @And("get a list")
    public void getList() throws InterruptedException {
        RestAssured.baseURI= "https://api.trello.com/1/boards/"+getTestingBoardID()+"/lists";

        RequestSpecification req = RestAssured.given();

        req.queryParam("key", key ).queryParam("token", token);

        req.header("Content-Type","application/json");

        Response response =req.get();
        response.prettyPrint();



        Thread.sleep(10000);
    }

    @Then("archive a list")
    public void archieveList() throws InterruptedException {
        RestAssured.baseURI= "https://api.trello.com/1/lists/"+getStartTestingListID()+"/closed";

        RequestSpecification req = RestAssured.given();

        req.queryParam("key", key ).queryParam("token", token).queryParam("value","true");
        req.header("Content-Type","application/json");

        Response response =req.put();
        response.prettyPrint();
        Thread.sleep(10000);
    }

    @And("delete a board")
    public void deleteBoard()
    {

        RestAssured.baseURI= "https://api.trello.com/1/boards/"+getTestingBoardID();

        RequestSpecification req = RestAssured.given();

        req.queryParam("key", key ).queryParam("token", token);
        req.header("Content-Type","application/json");


        Response response =req.delete();

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        response.prettyPrint();
    }

    @And("delete an organization")
    public void deleteOrg()
    {
        RestAssured.baseURI= "https://api.trello.com/1/organizations/"+getOrgID();

        RequestSpecification req = RestAssured.given();

        req.queryParam("key", key ).queryParam("token", token).queryParam("value","true");
        req.header("Content-Type","application/json");


        Response response =req.delete();

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);
        response.prettyPrint();
    }
}
