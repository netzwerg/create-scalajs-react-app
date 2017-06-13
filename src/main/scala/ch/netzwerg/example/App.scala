package ch.netzwerg.example

import ch.netzwerg.example.counter.CounterView
import org.scalajs.dom.document
import japgolly.scalajs.react.vdom.Implicits._

import scala.scalajs.js.JSApp

object App extends JSApp {

  def main(): Unit = {
    val modelConnection = new Circuit().connect(m => m)
    val component = modelConnection(proxy => CounterView(proxy.zoom(_.counter)))
    component.renderIntoDOM(document.getElementById("root"))
  }

}
