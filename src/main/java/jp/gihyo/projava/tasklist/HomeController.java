package jp.gihyo.projava.tasklist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class HomeController {

    private final TaskListDao dao;

    @Autowired
    HomeController(TaskListDao dao)
    {
        this.dao = dao;
    }// connect database

    record TaskItem(String id, String task, String deadline, boolean done) {}
    private List<TaskItem> taskItems = new ArrayList<>();//all

    @RequestMapping (value = "/hello")
    String hello(Model model){
        model.addAttribute("time", LocalDateTime.now());
        return "hello";
    }

    @GetMapping("/list")
    String listItems(Model model) {
        List<TaskItem>taskItems = dao.findAll();
        model.addAttribute("tasklist", taskItems);
        return "home";
    }

    @GetMapping ("/add")
    String addItem (@RequestParam("task") String task,
                    @RequestParam("deadline") String deadline) {
        String id = UUID.randomUUID().toString().substring (0, 8);
        TaskItem item = new TaskItem (id, task, deadline, false);
//        taskItems.add(item);

        dao.add(item);

        return "redirect:/list";
    }
    @GetMapping("/delete")
    String deleteItem(@RequestParam("id")String id){
        dao.delete(id);
        return "redirect:/list"; //すぐ出す
    }

    @GetMapping ("/update")
    String updateItem (@RequestParam("id") String id,
                       @RequestParam("task") String task,
                       @RequestParam("deadline") String deadline,
                       @RequestParam("done") boolean done) {

        TaskItem taskItem = new TaskItem (id, task, deadline,done);
//        taskItems.add(item);

        dao.update(taskItem);

        return "redirect:/list";
    }


/*    @RequestMapping(value="/hello")
    String hello (Model model) {
        model.addAttribute("time", LocalDateTime.now());
        return "hello";
*/
/*    @RequestMapping (value="/hello")
    @ResponseBody
    String hello() {
        return """
        <html>
        <head><title>Hello</title></head>
        <body>
        <h1>Hello</h1>
        It works!<br>
        現在時刻は%sです。
        </body></html>""".formatted(LocalDateTime.now());
 */
   // }
}
