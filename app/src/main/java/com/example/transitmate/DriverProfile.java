package com.example.transitmate;

public class DriverProfile {

    String name, imgRes, tripStart, tripEnd, tripDate, tripTime, carModel, location, gender, bio, travelPurpose, q1, a1, q2, a2, i1, i2, i3, i4, i5, memberSince, occupation;
    int rating, reviews, tripsAsDriver, passDriven, seatsLeft, seatPrice;
    boolean talks, likesMusic;

    public DriverProfile(String name, String imgRes, String tripStart, String tripEnd, String tripDate, String tripTime, String carModel, String location, String gender, String bio, String travelPurpose, String q1, String a1, String q2, String a2, String i1, String i2, String i3, String i4, String i5, String memberSince, String occupation, int rating, int reviews, int tripsAsDriver, int passDriven, int seatsLeft, int seatPrice, boolean talks, boolean likesMusic) {
        this.name = name;
        this.imgRes = imgRes;
        this.tripStart = tripStart;
        this.tripEnd = tripEnd;
        this.tripDate = tripDate;
        this.tripTime = tripTime;
        this.carModel = carModel;
        this.location = location;
        this.gender = gender;
        this.bio = bio;
        this.travelPurpose = travelPurpose;
        this.q1 = q1;
        this.a1 = a1;
        this.q2 = q2;
        this.a2 = a2;
        this.i1 = i1;
        this.i2 = i2;
        this.i3 = i3;
        this.i4 = i4;
        this.i5 = i5;
        this.memberSince = memberSince;
        this.occupation = occupation;
        this.rating = rating;
        this.reviews = reviews;
        this.tripsAsDriver = tripsAsDriver;
        this.passDriven = passDriven;
        this.seatsLeft = seatsLeft;
        this.seatPrice = seatPrice;
        this.talks = talks;
        this.likesMusic = likesMusic;
    }
}
