package main.scala

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

/**
  * Main Object
  * @version 1.0
  * @author Nikolai Dik
  */
object Main extends App{

  /**
    * Function to calculate exponential of number
    * @param Exp degree of number
    * @param Base number
    * @return function value
    */
  //first task without tail recursion
  def exponentiateRec(Base:Double, Exp:Double) : Double = {
    if (Exp == 0)
      1.0
    else
      Base * exponentiateRec(Base, Exp - 1)
  }

  /**
    * Function to calculate exponential of number with tail recursion
    * @param Exp degree of number
    * @param Base number
    * @return function value
    */
  //first task with tail rec
  def exponentiateTailRec(Base:Double, Exp:Double): Double = {
    @tailrec
    def _exponentiateTailRec(Result:Double, Exp:Double): Double = Exp match {
      case 0 => Result
      case _ => _exponentiateTailRec(Result*Base, Exp-1)
    }
    _exponentiateTailRec(1, Exp)
  }

  /**
    * Function to check if number from [start;end]
    * @param i number
    * @param start low border
    * @param end high border
    * @return Bool in Int
    */
  def checkSquare(i: Double, start: Int, end: Int): Int = {
    if (i*i >= start && i*i <= end ) 1
    else -1
  }

  /**
    * Function to fill Array with correct numbers
    * @param startValue low border
    * @param endValue high border
    * @return Array of nums
    */
  def findSquaresOnTheInterval(startValue: Int, endValue: Int): IndexedSeq[Int] =
  {
    if (startValue > endValue) IndexedSeq.empty
    def vector =
      for (i <- startValue to endValue if checkSquare(i,startValue,endValue) == 1) yield i
    vector
  }

  /**
    * Function to fill Array with correct numbers in tail rec
    * @param startValue low border
    * @param endValue high border
    * @param arr start empty Array to fill
    * @return Array of nums
    */
  @tailrec
  def findSquaresOnTheIntervalTail(startValue: Int, endValue: Int, arr: ArrayBuffer[Int]): ArrayBuffer[Int] =
  {
    if (startValue > endValue) arr
    else {
      if (checkSquare(startValue,startValue,endValue) == 1) arr += startValue
      findSquaresOnTheIntervalTail(startValue + 1, endValue, arr)
    }
  }


  ///////////////////////// Lab 6

  /**
    * Function remove none-nums elements
    * @param list list to convert
    * @return Array of string nums
    */
  def sortList(list: List[String]): List[String] = {
    list.filter((number: String) => ifToInt(number) >= 0 )
  }

  /**
    * Function to check if we can convert String to Int
    * @param s
    * @return converted num or -1 for error
    */
  def ifToInt(s: String): Int = {
    try {
      s.toInt.abs
    } catch {
      case e: Exception => -1
    }
  }



  def countListElemCount(list: List[Int]): Int = {
    list.foldLeft(0) {
      (right: Int, ind: Int) => right + 1
    }
  }

  def listStrTOListInt(listS: List[String]): List[Int] = {
    listS.filter((number: String) => ifToInt(number) >= 0 ).map((s: String) => s.toInt)
  }



/////////////////// Lab 7


  def convertString (string: String) : String = {
    string.map((c: Char)=>c match {
      case '_' => ' '
      case ' ' => '_'
      case _ => c
    })
  }

  def GetNotif(typeOfNotification: String, firstParam: String, secondParam: String, thirdParam: String = ""): String = {
    abstract class Notification
    case class Email(sender: String, title: String, body: String) extends Notification
    case class SMS(caller: String, message: String) extends Notification
    case class VoiceRecording(contactName: String, link: String) extends Notification

    def GetStringOfNotif(notif: Notification): String = {
      notif match{
        case Email(sender, title, body) => "New EMAIL!!! Sender: %s. Title: %s. Body: %s".format(sender, title, body)
        case SMS(caller, message) => "New SMS!!! Caller: %s. Message: %s".format(caller, message)
        case VoiceRecording(contactName, link) => "New VOICE RECORDING!!! Contact name: %s. Link: %s".format(contactName, link)
      }
    }

    typeOfNotification match {
      case "Email" => GetStringOfNotif(Email(firstParam, secondParam, thirdParam))
      case "SMS" => GetStringOfNotif(SMS(firstParam, secondParam))
      case "VoiceRecording" => GetStringOfNotif(VoiceRecording(firstParam, secondParam))
      case _ => "Incorrect type of notification"
    }
  }

























}
