class Vehicle {
  int passengers; // number of passengers
  int fuelcap;    // fueld capacity in gallons
  int mpg;        // fuel consumption in miles per gallons

  // parameterized constructor
  Vehicle(int p, int f, int m) {
    this.passengers = p;
    this.fuelcap = f;
    this.mpg = m;
  }

  // return the range
  int range() {
    return this.fuelcap * this.mpg;
  }

  // compute fuel needed for a given distance
  double fuelNeeded(int miles) {
    return (double) miles / this.mpg;
  }
}
