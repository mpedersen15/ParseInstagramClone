/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.List;


public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    /* ParseObject score = new ParseObject("Score");

    score.put("username", "rpedersen");
    score.put("score", 25);

    score.saveInBackground(new SaveCallback() {
        @Override
        public void done(ParseException e) {
            if (e == null) {
                Log.i("Success!", "score saved successfully!");
            } else {
                e.printStackTrace();
            }
        }
    });*/

      /*ParseQuery<ParseObject> query = ParseQuery.getQuery("Score");

      query.getInBackground("6GLfPaZaVD", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject object, ParseException e) {
              if (e == null && object != null) {

                  object.put("score", 30);

                  object.saveInBackground();

                  Log.i("Username: ", object.getString("username") + ". Score: " + object.getInt("score"));
              }
          }
      });*/

      /*ParseObject tweet = new ParseObject("Tweet");

      tweet.put("username", "mpedersen15");

      tweet.put("tweet", "Hey guys, this is my first tweet!");

      tweet.saveInBackground(new SaveCallback() {
          @Override
          public void done(ParseException e) {
              if (e == null) {
                  Log.i("Success!", "Saved the tweet!");
              } else {
                e.printStackTrace();
              }
          }
      });*/


     /* ParseQuery<ParseObject> query = ParseQuery.getQuery("Tweet");

      query.getInBackground("gF4c5Sz7BV", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject object, ParseException e) {
              if (e == null && object != null) {
                  Log.i("Received Tweet", object.getString("username") + " said: " + object.getString("tweet"));

                  object.put("tweet", "Oops, had to update this tweet!");

                  object.saveInBackground();
              }
          }
      });*/

     ParseQuery<ParseObject> findAllQuery = ParseQuery.getQuery("Score");

     findAllQuery.whereEqualTo("username", "mpedersen");

     findAllQuery.findInBackground(new FindCallback<ParseObject>() {
         @Override
         public void done(List<ParseObject> objects, ParseException e) {
             if (e == null) {
                 if (objects.size() > 0) {
                     for (ParseObject object : objects) {
                         Log.i("Found: ", object.getString("username") + " - " + object.getInt("score"));
                     }
                 }
             }
         }
     });

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}