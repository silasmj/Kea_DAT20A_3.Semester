package dk.kea.trash_api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class TrashController {

    static String[] deadlySins = {"Greed", "Gluttony", "Wrath", "Envy", "Lust", "Sloth", "Pride"};


    //Dette er en route
    @GetMapping("/") //"/" er root
    public String frontPage () {
        return "Jeg kunne godt drikke en monner :)";
    }

    // todo create a clock that sends back the time - on the endpoint clock
    @GetMapping("/clock")
    public Date clock () {
        return new Date();
    }
    @GetMapping("/sevendeadlysins/{deadlysin}")
    public String sevenDeadlySins(@PathVariable("deadlysin") int deadlysin) {
        try{
            return deadlySins[deadlysin];
        }catch (Exception error) {
            return "Error - There's only 7 deadly sins";
        }
    }
    //Send data back to client
    //URL = http://localhost:8080/trash?trash=socks
    @GetMapping("/trash")
    public String throwTrashBackAtClient(@RequestParam String trash) {
        return trash + ", This is trash";
    }

    @PostMapping("/rubbishbin")
    public String throwOutRubbish(@RequestBody String rubbish) {
        System.out.println(rubbish);
        return "Everything went well";
    }
}
