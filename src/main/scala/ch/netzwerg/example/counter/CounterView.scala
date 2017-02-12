package ch.netzwerg.example.counter

import diode.react.ModelProxy
import japgolly.scalajs.react.ReactComponentB
import japgolly.scalajs.react.vdom.prefix_<^._

object CounterView {

  case class Props(modelProxy: ModelProxy[CounterModel])

  private val component = ReactComponentB[Props](this.getClass.getSimpleName)
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
