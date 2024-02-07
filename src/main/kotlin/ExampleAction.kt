sealed class ExampleAction {

    data class UpdateName(val newName: String) : ExampleAction()
    data class UpdateAge(val newAge: Int) : ExampleAction()

    data object MakeAvailable: ExampleAction()

    data object MakeUnavailable: ExampleAction()

}