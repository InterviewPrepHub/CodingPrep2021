package Stripe;


/*
Consider a system of User and Feature objects, where a Feature describes the availability of
an ongoing project or change in functionality. Features may be generally available, limited to
certain regions, and/or intended for an A/B test. We need to write a deterministic system for
identifying which Features are active for a given User. We also want to write tests to ensure
that our system is working as intended each time we run it, given the example User and Feature
data below.

Users:

[
    { "id": 0, "name": "eva",    "location": "US" },
    { "id": 1, "name": "tess",   "location": "US" },
    { "id": 2, "name": "rahool", "location": "CA" },
    { "id": 3, "name": "amanda", "location": "CA" }
]

location && abtest

Features:

[
    {
        "id": "annual_sale",
        "locations": ["US","CA"],
        "abTest": true,
    },
    {
        "id": "enhanced_comments",
//        "location" : null
        "abTest": true,
    },
    {
        "id": "canada_promotion",
        "locations": ["CA"],
//        "abtest":true
    }
]

case 1 : location - match abtest - true  & use id = even return set<f_id>

case 2 : location - does not match, abtest - true  & use id = even return dont add in set

case 2 : location - match, abtest - false  & use id = even return  set<f_id>

case 2 : location - did not match/null, abtest - true  & use id = even return  set<f_id>

## Part 1

Write a function, `get_user_features(user, features)` which takes a single User object and a list
of Feature objects and returns a set of the Feature IDs that apply to the given User.

A User has three properties: an integer `id`, a string `name`, and a 2-letter country code
string `location`.

A Feature has three properties: a unique string `id`, an optional array of 2-letter country code
strings, `locations`, which limits the feature to users with a matching location, and an optional
boolean, `abTest`, which when set to true will only apply the feature to users with an even user ID.


If `abTest` or `locations` are absent for a Feature, they have no effect.

Given the features and users, the following results are expected:

| User   | Features                            |
| ------ | ----------------------------------- |
| eva    | annual_sale, enhanced_comments      |
| tess   | N/A                                 |
| rahool | enhanced_comments, canada_promotion |
| amanda | canada_promotion                    |

*/


import java.util.*;

class User {

    int id;
    String location;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    User(int id, String location, String name) {
        this.id = id;
        this.location = location;
        this.name = name;
    }

}

class Feature {

    String id;
    String[] locations;
    boolean abTest;

    public Feature(String id, String[] locations, boolean abTest) {
        this.id = id;
        this.locations = locations;
        this.abTest = abTest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getLocations() {
        return locations;
    }

    public void setLocations(String[] locations) {
        this.locations = locations;
    }

    public boolean isAbTest() {
        return abTest;
    }

    public void setAbTest(boolean abTest) {
        this.abTest = abTest;
    }



}


public class Test {

    Set<String> resultSet = new HashSet<>();


    public Set<String> get_user_features(User user, List<Feature> featureList) {

        String userLocation = user.getLocation();
        int id = user.getId();

        for (Feature f : featureList) {

            List<String> locList = Arrays.asList(f.getLocations());

            if(locList.contains(userLocation)) {
                if(f.abTest == true && id%2==0) {
                    resultSet.add(f.getId());
                }
            }
        }

        return resultSet;

    }


    public static void main(String[] args) {

        Test t = new Test();
        User user = new User(0, "US", "eva");

        Feature feature = new Feature("annual_sale", new String[]{"US"}, true);

        List<Feature> list = new ArrayList<>();
        list.add(feature);

        t.get_user_features(user, list);
        
    }


}



