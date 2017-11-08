package csw.deploy.containercmd

import csw.apps.containercmd.ContainerCmd

object NfiraosContainerCmdApp extends App {
  ContainerCmd.start("NFIRAOS-Container-Cmd", args)
}
