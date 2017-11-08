package csw.deploy.hostconfig

import csw.apps.hostconfig.HostConfig

object NfiraosHostConfigApp extends App {
  HostConfig.start("NFIRAOS-Host-Config", args)
}
