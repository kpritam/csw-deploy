package csw.deploy.hostconfig.cli

import java.io.ByteArrayOutputStream
import java.nio.file.Paths

import org.scalatest.{BeforeAndAfterEach, Matchers}

// DEOPSCSW-175: Starting multiple containers from command Line
class ArgsParserTest extends org.scalatest.FunSuite with Matchers with BeforeAndAfterEach {
  val inputFilePath         = "/tmp/some/input/file"
  val containerCmdAppScript = "./bin/container-cmd-app"

  //Capture output/error generated by the parser, for cleaner test output. If interested, errCapture.toString will return capture errors.
  val outCapture = new ByteArrayOutputStream
  val errCapture = new ByteArrayOutputStream

  override protected def afterEach(): Unit = {
    outCapture.reset()
    errCapture.reset()
  }

  def silentParse(args: Array[String]): Option[Options] =
    Console.withOut(outCapture) {
      Console.withErr(errCapture) {
        new ArgsParser().parser.parse(args, Options())
      }
    }

  test("should able to parse when all arguments are provided") {
    val args                     = Array("--local", inputFilePath, "--container-script", containerCmdAppScript)
    val options: Option[Options] = silentParse(args)
    options should contain(
      Options(local = true, Some(Paths.get(inputFilePath)), Some(containerCmdAppScript))
    )
  }

  test("should able to parse arguments with default value of false when local option is not provided") {
    val args                     = Array(inputFilePath, "-s", containerCmdAppScript)
    val options: Option[Options] = silentParse(args)
    options should contain(
      Options(local = false, Some(Paths.get(inputFilePath)), Some(containerCmdAppScript))
    )
  }

  test("should not parse if inputFilePath is not provided") {
    val args                     = Array("--local", "--container-script", containerCmdAppScript)
    val options: Option[Options] = silentParse(args)
    options shouldBe None
  }

  test("should not parse if no arguments provided") {
    val args                     = Array[String]()
    val options: Option[Options] = silentParse(args)
    options shouldBe None
  }
}
