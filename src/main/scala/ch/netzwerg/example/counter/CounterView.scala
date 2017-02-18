package ch.netzwerg.example.counter

import diode.react.ModelProxy
import japgolly.scalajs.react.vdom.prefix_<^._
import japgolly.scalajs.react.{Callback, ReactComponentB}
import org.singlespaced.d3js.d3

object CounterView {

  val divId = "myDiv"

  case class Props(modelProxy: ModelProxy[CounterModel])

  private val component = ReactComponentB[Props](this.getClass.getSimpleName)
    .render_P { p =>
      <.div(
        <.button(^.onClick --> p.modelProxy.dispatchCB(Decrement), "-"),
        p.modelProxy.value.currentCounter,
        <.button(^.onClick --> p.modelProxy.dispatchCB(Increment), "+"),
        <.div(^.id := divId, ^.width := p.modelProxy.value.previousCounter.px, ^.height := 20.px, ^.backgroundColor := "steelblue")
      )
    }
    .componentDidUpdate { $ =>
      Callback {
        d3.select(s"#$divId")
          .transition()
          .duration(750)
          .style("width", $.currentProps.modelProxy.value.currentCounter + "px")
      }
    }
    .build

  def apply(modelProxy: ModelProxy[CounterModel]) = component(Props(modelProxy))

}
