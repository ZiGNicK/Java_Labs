import org.scalatest.FunSuite
import main.scala.Main

import scala.collection.mutable.ArrayBuffer

class test extends FunSuite {

  test("firstTaskRec") {
    assert(Main.exponentiateRec(5,2) === 25 )
    assert(Main.exponentiateRec(1,1) === 1 )
    assert(Main.exponentiateRec(10,0) === 1 )
  }

  test("firstTaskTailRec") {
    assert(Main.exponentiateTailRec(3,3) === 27 )
    assert(Main.exponentiateTailRec(2,8) === 256 )
    assert(Main.exponentiateTailRec(10,3) === 1000 )
  }


  test("secondTaskLab5"){
    assert(Main.findSquaresOnTheInterval(0,10) === IndexedSeq(0,1,2,3) )
    assert(Main.findSquaresOnTheInterval(12,10) === IndexedSeq.empty )
    assert(Main.findSquaresOnTheInterval(-2,10) === IndexedSeq(-2, -1, 0, 1, 2, 3) )


    assert(Main.findSquaresOnTheIntervalTail(0,10, ArrayBuffer.empty) === ArrayBuffer(0,1,2,3) )
    assert(Main.findSquaresOnTheIntervalTail(200,10, ArrayBuffer.empty) === ArrayBuffer.empty )
    assert(Main.findSquaresOnTheIntervalTail(-10,10, ArrayBuffer.empty) === ArrayBuffer(-3,-2,-1,0,1,2,3) )
  }


  /////////////// Lab 6

  test("firstTaskLab6") {
    assert(Main.sortList(List("bb", "-1", "55", "a")) === (List("-1", "55")))
    assert(Main.sortList(List("hello", "my", "dear", "friend")) === (List.empty))
   }

  test("2ndTaskLab6"){
    assert(Main.countListElemCount(List(1,2,3,4,8)) === 5)
  }

  test("3rdTaskLab6"){
    assert(Main.listStrTOListInt(List("2", "d<", "3")) === List(2,3))
  }




  test("firstTask7Lab") {
    assert(Main.convertString("abc aaa_bbb" )  === "abc_aaa bbb")
  }

  test("secondTask7Lab") {
    assert(Main.GetNotif("Email", "Vasi", "Vacation", "JUST GO!")  === "New EMAIL!!! Sender: Vasi. Title: Vacation. Body: JUST GO!")
    assert(Main.GetNotif("SMS", "Emm", "Hello")  === "New SMS!!! Caller: Emm. Message: Hello")
    assert(Main.GetNotif("VoiceRecording", "Josh", "www.xxx...")  === "New VOICE RECORDING!!! Contact name: Josh. Link: www.xxx...")
  }
































}
