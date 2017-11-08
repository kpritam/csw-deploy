package csw.deploy.hostconfig

import csw.apps.hostconfig.HostConfig

object IrisHostConfigApp extends App {
  HostConfig.start("IRIS-HostConfig", args)
}
