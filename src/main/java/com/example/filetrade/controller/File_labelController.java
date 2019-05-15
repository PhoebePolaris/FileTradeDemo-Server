package com.example.filetrade.controller;

import com.example.filetrade.entity.File_label;
import com.example.filetrade.service.File_labelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lenovo on 2019/5/15.
 */
@RestController
@RequestMapping("/file_label")
public class File_labelController {
    @Autowired
    private File_labelService file_labelService;

    //add
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String post(@RequestBody File_label file_label){
//            @RequestParam(value = "file_id") String file_id,
//                        @RequestParam(value = "label_1")String label_1,
//                        @RequestParam(value = "label_2")String label_2,
//                        @RequestParam(value = "label_3")String label_3) {
//        File_label file_label = new File_label();
//        file_label.setFile_id(file_id);
//        file_label.setLabel_1(label_1);
//        file_label.setLabel_2(label_2);
//        file_label.setLabel_3(label_3);
        int t = file_labelService.add(file_label);
        if (t == 1) {
            return file_label.toString();
        } else {
            return "fail";
        }
    }

    //update
    //更新标签
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String update(@RequestBody File_label file_label){
//            @PathVariable("file_id") String file_id,
//                         @RequestParam(value = "label_1", required = true) String label_1,
//                         @RequestParam(value = "label_2", required = true) String label_2,
//                         @RequestParam(value = "label_3", required = true) String label_3) {
//        File_label file_label = new File_label();
//        file_label.setFile_id(file_id);
//        file_label.setLabel_1(label_1);
//        file_label.setLabel_2(label_2);
//        file_label.setLabel_3(label_3);
        //**********************加一个判断，只有creator可以修改标签
        int t = file_labelService.update(file_label);
        if (t == 1) {
            return file_label.toString();
        } else {
            return "fail";
        }
    }

    //search
    @RequestMapping(value = "/{file_id}", method = RequestMethod.GET)
    public File_label getFile_labelByFile_id(@PathVariable("file_id") String file_id) {
        return file_labelService.findFile_labelByFile_id(file_id);
    }
}
