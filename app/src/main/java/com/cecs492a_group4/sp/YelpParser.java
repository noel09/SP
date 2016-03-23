package com.cecs492a_group4.sp;
import java.io.*;
import java.util.*;
import java.text.*;
import java.lang.*;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;
import java.lang.Object;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

//

public class YelpParser {

    private String yelp_response;
    private ArrayList<String> keys = new ArrayList<String>();
    private HashMap<String, String> yelp_bundle = new HashMap<String, String>();
    private ArrayList<String> image_url = new ArrayList<String>();
    private ArrayList<String> mobile_url = new ArrayList<String>();
    private ArrayList<String> distance = new ArrayList<String>();
    private ArrayList<String> rating = new ArrayList<String>();
    private ArrayList<String> bAddress = new ArrayList<String>();
    private ArrayList<String> rating_url = new ArrayList<String>();

    /**
     * Sets Yelp's response for this class
     * @param response
     */
    public void setResponse(String response){yelp_response = response;}

    /**
     * Returns the set Yelp response
     * @return string yelp_response
     */
    public String getResponse(){return yelp_response;}

    /**
     * Parse's yelp's response for the business name; mobile url; and ratings url.
     * Mobile url and ratings url is separated by " ,,, "
     * @sets yelp_bundle(key = business name)
     * @sets keys arraylist with business name
     * @throws JSONException
     */
    public void parseBusiness() throws JSONException {
        JSONObject o1 = new JSONObject(yelp_response);
        JSONArray businesses = o1.getJSONArray("businesses");
        String tmpString;
        String businessName;
        String address, city, zipcode, state;
        JSONObject businessTemp;
        JSONObject bLocation;
        keys.removeAll(keys);
        yelp_bundle.clear();
        for (int i = 0; businesses.length() > i; i++){

/*
            tmpString = "yMobileUrl" + businesses.getJSONObject(i).get("mobile_url").toString() + "yRating" +
                    businesses.getJSONObject(i).get("rating").toString() + "yLocation" +
                    businesses.getJSONObject(i).get("location").toString() + "yImageUrl" +
                    businesses.getJSONObject(i).get("image_url").toString();
            keys.add(businesses.getJSONObject(i).get("name").toString());
            yelp_bundle.put(keys.get(i), tmpString);
*/

            businessTemp = businesses.getJSONObject(i);

            //Store the business name to the arraylist
            businessName = businessTemp.get("name").toString();
            keys.add(businessName);

            //Store the business web's url to the array list
            tmpString = businessTemp.get("mobile_url").toString();
            mobile_url.add(tmpString);

            //Store the business' rating to the array list
            tmpString = businessTemp.get("rating").toString();
            rating.add(tmpString);

            //Store the business' image rating url to the array list
            tmpString = businessTemp.get("rating_img_url").toString();
            rating_url.add(tmpString);

            //Store the distance to the business to the array list
            try {
                tmpString = businessTemp.get("distance").toString();
                distance.add(tmpString);
            }catch (Exception excpt){
                distance.add("-1");
            }

            //Store the business' image url to the array list
            tmpString = businessTemp.get("image_url").toString();
            image_url.add(tmpString);

            //Get the address, zipcode, city, state
            bLocation = businessTemp.getJSONObject("location");
            tmpString = bLocation.get("address").toString();
            address = tmpString.substring(2, tmpString.length() - 2);
            zipcode = bLocation.get("postal_code").toString();
            city = bLocation.get("city").toString();
            state = bLocation.get("state_code").toString();

            //Store the business location to the array list
            bAddress.add(address + ", " + city + ", " + state + " " + zipcode);
        }
    }


    /**
     * Gets the business name, assuming you supply the bundle, key, and int
     * In reality, all it does is pull myKey.get(i), but I added the myBundle
     * param to try and force all information to be there.
     * @param myBundle
     * @param myKey
     * @param i
     * @return myKey.get(i)
     */
    public String getBusinessName(HashMap<String, String> myBundle, ArrayList<String> myKey, int i){return myKey.get(i);}

    /**
     * This gets the business's name, which is stored in the ArrayList keys, using
     * this class's stored results.
     * @param i
     * @return
     */
    public String getBusinessName(int i){return keys.get(i);}

    /**
     * This returns the mobile URL using this class's internally stored variables at int i.
     * For ease of use I suggest using this method.
     *
     * @param i
     * @return mobileURL
     */
    public String getBusinessMobileURL(int i){
        return mobile_url.get(i);
    }

    public String getBusinessRating(int i){
        return rating.get(i);
    }

    public String getBusinessRatingUrl(int i){
        return rating_url.get(i);
    }

    public String getBusinessAddress(int i){
        return bAddress.get(i);
    }

    public String getBusinessImageURL(int i){
        return image_url.get(i);
    }

    public String getBusinessDistance(int i){
        return distance.get(i);
    }

    /**
     * Returns the bundle, key is the business name.
     * @return yelp_bundle
     */
    public HashMap<String, String> getYelpBundle(){return yelp_bundle;}

    /**
     * Returns the keys (business names) for the yelpBundle.
     * @return keys (business names)
     */
    public ArrayList<String> getBundleKeys(){return keys;}

    /**
     * This will return the keys.size(), and is designed to be used with loops
     * @return keys.size()
     */
    public int getBundleKeysSize(){int size = keys.size(); return size; }

    public void clearArrayList(YelpParser y){y.keys.clear();}

}