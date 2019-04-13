package com.ford.cvpp.nudgeserver;


public class NudgeCommand {
  /**
   * JSON Example:
   * {
   *   "method":"nudge",
   *   "vehicleID":"VIN123",
   *   "distance":"2 meters",
   *   "direction":"forward"
   * }
   */
  private String method;
  private String vehicleID;
  private String distance;
  private String direction;

  public NudgeCommand(String method, String vehicleID, String distance, String direction) {
    this.method = method;
    this.vehicleID = vehicleID;
    this.distance = distance;
    this.direction = direction;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getVehicleID() {
    return vehicleID;
  }

  public void setVehicleID(String vehicleID) {
    this.vehicleID = vehicleID;
  }

  public String getDistance() {
    return distance;
  }

  public void setDistance(String distance) {
    this.distance = distance;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }
}
