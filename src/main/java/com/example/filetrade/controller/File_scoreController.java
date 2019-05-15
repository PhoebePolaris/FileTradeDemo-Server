package com.example.filetrade.controller;

import com.example.filetrade.entity.File_score;
import com.example.filetrade.service.File_scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2019/5/15.
 */

@RestController
@RequestMapping("/file_score")
public class File_scoreController {
    @Autowired
    private File_scoreService file_scoreService;

    //add
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(@RequestBody File_score file_score){
//            @RequestParam(value = "file_id") String file_id,
//                       @RequestParam(value = "from_user_id")String user_id,
//                       @RequestParam(value = "score")int score) {
//        File_score file_score = new File_score();
//        file_score.setFile_id(file_id);
//        file_score.setScore(score);
//        file_score.setFrom_user_id(user_id);
        int t = file_scoreService.add(file_score);
        if (t == 1) {
            return file_score.toString();
        } else {
            return "fail";
        }
    }

    //update
    //更新给分
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody File_score file_score){
//            @PathVariable("file_id") String file_id,
//                         @PathVariable(value = "from_user_id") String user_id,
//                         @RequestParam(value = "score", required = true) int score) {
//        File_score file_score = new File_score();
//        file_score.setFile_id(file_id);
//        file_score.setScore(score);
//        file_score.setFrom_user_id(user_id);

        int t = file_scoreService.update(file_score);
        if (t == 1) {
            return file_score.toString();
        } else {
            return "fail";
        }
    }

    //search
    @RequestMapping(value = "/{file_id}", method = RequestMethod.GET)
    public List<File_score> getFile_scoreByFile_id(@PathVariable("file_id") String file_id) {
        return file_scoreService.findFile_scoreByFile_id(file_id);
    }

    //search
    @RequestMapping(value = "/{file_id}/{from_user_id}", method = RequestMethod.GET)
    public File_score getFile_scoreByFile_id(@PathVariable("file_id") String file_id,
                                              @PathVariable("from_user_id") String user_id) {
        return file_scoreService.findFile_scoreByFile_idAndUser_id(file_id,user_id);
    }
}
