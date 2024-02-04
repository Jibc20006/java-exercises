package jibc5.tasklist;

import jakarta.annotation.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class HomeRestController {


    record TaskItem(String id, String task, String deadline, String timea, int guests,String seat, String phone, boolean done){}
    private List<TaskItem>taskItems = new ArrayList<>();

    @RequestMapping(value = "/resthello")
    String hello(){
        return """
                    Hello.
                    It Works!
                    現在時刻は　%s　です。
                """.formatted(LocalDateTime.now());
    }

    @GetMapping(value = "/restadd")
    String addItem(@RequestParam("task") String task,
                   @RequestParam("deadline")String deadline,
                    @RequestParam("timea")String timea,
                    @RequestParam("guests")int guests,
                   @RequestParam("seat")String seat,
                   @RequestParam("phone")String phone){

        String id = UUID.randomUUID().toString().substring(0,8);
        TaskItem item = new TaskItem(id,task,deadline,timea,guests,seat,phone,false);
        taskItems.add(item);

        return "タスクを追加しました。";
    }
    @GetMapping("/restlist")
    String ListItems(){
        String result = taskItems.stream()
                .map(TaskItem::toString)
                .collect(Collectors.joining(","));
        return result;
    }
}
