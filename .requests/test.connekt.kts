import org.assertj.core.api.Assertions

val baseUrl: String by env
val path = "greeting"

GET("$baseUrl/$path") {
    accept("application/json")
} then {
    Assertions.assertThat(code).isEqualTo(200)
}
