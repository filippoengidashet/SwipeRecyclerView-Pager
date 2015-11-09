package org.dalol.swiperecyclerview_pager.model;

/**
 * @author Filippo Ash
 * @version 1.0.0
 * @date 11/8/2015
 */
public class Planet {

    private String mName;

    private int mImage;

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        this.mImage = image;
    }

    private double mMass, mDiameter, mDensity, mOblateness, mRotation, mDistance, mRevolution, mEccentricity, mInclination, mAxisTilt;

    public double getMass() {
        return mMass;
    }

    public void setMass(double mass) {
        mMass = mass;
    }

    public double getDiameter() {
        return mDiameter;
    }

    public void setDiameter(double diameter) {
        mDiameter = diameter;
    }

    public double getDensity() {
        return mDensity;
    }

    public void setDensity(double density) {
        mDensity = density;
    }

    public double getOblateness() {
        return mOblateness;
    }

    public void setOblateness(double oblateness) {
        mOblateness = oblateness;
    }

    public double getRotation() {
        return mRotation;
    }

    public void setRotation(double rotation) {
        mRotation = rotation;
    }

    public double getDistance() {
        return mDistance;
    }

    public void setDistance(double distance) {
        mDistance = distance;
    }

    public double getRevolution() {
        return mRevolution;
    }

    public void setRevolution(double revolution) {
        mRevolution = revolution;
    }

    public double getEccentricity() {
        return mEccentricity;
    }

    public void setEccentricity(double eccentricity) {
        mEccentricity = eccentricity;
    }

    public double getInclination() {
        return mInclination;
    }

    public void setInclination(double inclination) {
        mInclination = inclination;
    }

    public double getAxisTilt() {
        return mAxisTilt;
    }

    public void setAxisTilt(double axisTilt) {
        mAxisTilt = axisTilt;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }
}
