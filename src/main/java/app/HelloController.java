package app;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Produces;

@Controller("/")
public class HelloController {

    @Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }

    @Produces(MediaType.TEXT_HTML)
    @Get("/{day}")
    public String home(String day) {
        var isWeekend = switch (day.toLowerCase()) {
            case "saturday", "sunday" -> true;
            case "monday", "tuesday", "wednesday", "thursday", "friday" -> false;
            default -> false;
        };
        return String.format(
                """
                        <!DOCTYPE html>
                                    <html>
                                        <body>
                                            <p>
                                                It's %s, it is %s the weekend!
                                            </p>
                                        </body>
                                   </html>
                                   """,
                day, (isWeekend ? "" : "not"));

    }
}