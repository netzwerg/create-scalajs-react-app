package ch.netzwerg.example

import ch.netzwerg.example.counter.{CounterHandler, CounterModel}
import diode.react.ReactConnector

class Circuit extends diode.Circuit[Model] with ReactConnector[Model] {

  protected def initialModel = Model(CounterModel(42, 42))

  protected def actionHandler = new CounterHandler[Model](zoomRW(_.counter)((m, v) => m.copy(counter = v)))

}