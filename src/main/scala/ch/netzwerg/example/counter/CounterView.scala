package ch.netzwerg.example.counter

import diode.react.ModelProxy
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._

object CounterView {

  case class Props(modelProxy: ModelProxy[CounterModel])

  private val component = ScalaComponent.builder[Props](this.getClass.getSimpleName)
    .render_P { p =>
      <.div(
        <.button(^.onClick --> p.modelProxy.dispatchCB(Decrement), "-"),
        p.modelProxy.value.counter,
        <.button(^.onClick --> p.modelProxy.dispatchCB(Increment), "+")
      )
    }
    .build

  def apply(modelProxy: ModelProxy[CounterModel]) = component(Props(modelProxy))

}
