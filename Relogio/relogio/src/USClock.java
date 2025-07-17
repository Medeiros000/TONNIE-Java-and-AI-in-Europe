public non-sealed class USClock extends Clock {

  public String periodIndicator;

  public String getPeriodIndicator() {
    return periodIndicator;
  }

  public void setPeriodIndicator(String periodIndicator) {
    this.periodIndicator = periodIndicator;
  }

  public void setAfterMidday() {
    this.periodIndicator = "PM";
  }

  public void setBeforeMidday() {
    this.periodIndicator = "PM";
  }

  @Override
  public void setHour(int hour) {
    setBeforeMidday();
    if (hour >= 12 && (hour < 24)) {
      this.hour = hour - 12;
      setAfterMidday();
    } else if (hour >= 24) {
      this.hour = 0;
    } else {
      this.hour = hour;
    }
  }

  @Override
  public Clock convert(final Clock clock) {

    this.second = clock.getSecond();
    this.minute = clock.getMinute();
    switch (clock) {
      case USClock usClock -> {
        this.hour = usClock.getHour();
        this.periodIndicator = usClock.getPeriodIndicator();
      }
      case BRLClock brlClock -> this.setHour(brlClock.getHour());
    }
    return this;
  }

  @Override
  public String getTime() {
    return super.getTime() + " " + this.periodIndicator;
  }
}
