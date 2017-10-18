package com.demo.simplenote.refactor;

import android.support.annotation.NonNull;

import com.demo.simplenote.domain.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mrsimple on 18/10/17.
 */

public class ExtractMethod {

    // 输出数据库中所有学生的信息
    public void printNotesInfo() {
        // 构建结果集
        List<Note> allNotes = new ArrayList<Note>();
        // 模拟从数据库获取所有学生信息
        for (int i = 5; i > 0 ; i--) {
            Note Note = new Note();
            Note.id = i;
            Note.title = "title - " + i;
            Note.content = "content - " + i;
            // 添加到集合中
            // 添加到集合中
            allNotes.add(Note) ;
        }

        if ( allNotes != null && allNotes.size() > 0 ) {
            Collections.sort(allNotes, new Comparator<Note>() {
                @Override
                public int compare(Note lhs, Note rhs) {
                    return (int) (lhs.id - rhs.id);
                }
            });

            for (Note Note : allNotes) {
                System.out.println("### Note Info : " + Note);
            }
        }
    }



    // ==== 重构版本

    public void printNotesInfoV2() {
        // 读取 note 数据
        List<Note> allNotes = loadNoteFromDb();
        if ( allNotes != null && allNotes.size() > 0 ) {
            // 排序
            sortNotesWithNoteId(allNotes);
            // 输出信息
            outputNotesInfo(allNotes);
        }
    }

    @NonNull
    private List<Note> loadNoteFromDb() {
        // 构建结果集
        List<Note> allNotes = new ArrayList<Note>();
        // 模拟从数据库获取所有学生信息
        for (int i = 5; i > 0 ; i--) {
            Note Note = new Note();
            Note.id = i;
            Note.title = "title - " + i;
            Note.content = "content - " + i;
            // 添加到集合中
            // 添加到集合中
            allNotes.add(Note) ;
        }
        return allNotes;
    }

    private void outputNotesInfo(List<Note> allNotes) {
        for (Note Note : allNotes) {
            System.out.println("### Note Info : " + Note);
        }
    }

    private void sortNotesWithNoteId(List<Note> allNotes) {
        Collections.sort(allNotes, new Comparator<Note>() {
            @Override
            public int compare(Note lhs, Note rhs) {
                return (int) (lhs.id - rhs.id);
            }
        });
    }
}
