package csw.deploy.containercmd

import csw.apps.containercmd.ContainerCmd

object IrisContainerCmdApp extends App {
  ContainerCmd.start("IRIS-Container-Cmd", args)
}
