package ch.netzwerg.example

import ch.netzwerg.example.counter.CounterView
import japgolly.scalajs.react.ReactDOM
import org.scalajs.dom.document

import scala.scalajs.js.JSApp

object App extends JSApp {

  def main(): Unit = {
    val modelConnection = new Circuit().connect(m => m)
    val component = modelConnection(proxy => CounterView(proxy.zoom(_.counter)))
    ReactDOM.render(component, document.getElementById("root"))
  }

}
