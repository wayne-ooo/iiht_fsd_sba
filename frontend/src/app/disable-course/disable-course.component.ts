import { Component, OnInit, Inject, Input } from '@angular/core';
import {FormBuilder, Validators, FormGroup} from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import * as moment from 'moment';
import { CourseService } from '../service/course.service';
import { AlertService } from '../service/alert.service';
import { first } from 'rxjs/operators';

@Component({
    selector: 'app-disable-course',
    templateUrl: './disable-course.component.html',
    styleUrls: ['./disable-course.component.css']
})
export class DisableCourseComponent implements OnInit {

    form: FormGroup;
    loading = false;
    submitted = false;
    courseid: string;
    constructor(
        private fb: FormBuilder,
        private dialogRef: MatDialogRef<DisableCourseComponent>,
        @Inject(MAT_DIALOG_DATA) {courseid},
        private courseService: CourseService,
        private alertService: AlertService) {
        this.courseid = courseid;
        this.form = fb.group({
            days: ['', Validators.required]
        });
    }

    ngOnInit() {
    }

    save() {
        if (this.form.valid) {

            this.submitted = true;

            // reset alerts on submit
            this.alertService.clear();

            this.loading = true;
            console.log('this.courseid');
            console.log(this.courseid);
            console.log('this.form.value.days');
            console.log(this.form.value.days);
            this.courseService.updateCourse(this.courseid, this.form.value.days)
                .pipe(first())
                .subscribe(
                    data => {
                        // tslint:disable-next-line:no-string-literal
                        if (data['code'] === 200) {
                            // tslint:disable-next-line:no-string-literal
                            this.alertService.success(data['message']);
                            this.dialogRef.close();
                        }
                    },
                    error => {
                        this.alertService.error(error);
                        this.loading = false;
                    });
           // this.dialogRef.close(course);
        }
    }

    close() {
        this.dialogRef.close();
    }

}
