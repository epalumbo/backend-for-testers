package com.calipsoide.backend4testers.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Logging {

  default Logger log() {
    return LoggerFactory.getLogger(getClass());
  }

}
