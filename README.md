# Band Tracker
Independent Project written in Java Using the Spark Microframework.

## Description

practice in java, gradle, velocity, and sparkJava

## Setup/Installation Requirements

* _Clone this repository_
* _Install the [Java SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) and [Java SRE](http://www.java.com/en/)._
* _[Install gradle](http://codetutr.com/2013/03/23/how-to-install-gradle/)_

* _Navigate back to the directory where this repository has been cloned and run gradle:_
* _CREATE DATABASE band_tracker;_
* _\c band_tracker;_
* _CREATE TABLE venues (id serial PRIMARY KEY, venue_name varchar, address varchar);_
* _CREATE TABLE bands (id serial PRIMARY KEY, band_name varchar, genre varchar);_
* _CREATE TABLE venues_bands (id serial PRIMARY KEY, venue_id int, band_id int);_
* _CREATE DATABASE band_tracker_test WITH TEMPLATE band_tracker;_
```
$ gradle run
```
* _Open localhost:4567 in a browser._

## Known Bugs

_No current known bugs._

## Support and contact details

_To contact, leave a comment on Github._

## Technologies Used

* _Java_
* _JUnit_
* _FluentLenium_
* _Gradle_
* _Spark_

### License

*MIT License*

Copyright (c) 2016 **_Ryan Carlile_**
