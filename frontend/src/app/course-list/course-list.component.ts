import {Component, Input, OnInit} from '@angular/core';
import {CourseService} from '../service/course.service';
import {AlertService} from '../service/alert.service';
import {Course} from '../models/course';
import {MatDialog, MatDialogConfig} from '@angular/material/dialog';
import { DisableCourseComponent } from '../disable-course/disable-course.component';
import {User} from '../models/user.model';
import {AuthenticationService} from '../service/authentication.service';
import { AddCourseComponent } from '../add-course/add-course.component';
@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {
    currentUser: User;
    courses: Course[];
    showCourse: boolean;
    @Input() userRole: string;
    @Input() searchText: string;

    constructor(private authenticationService: AuthenticationService,private courseservice: CourseService,
                private alertService: AlertService,
                public dialog: MatDialog) {
        this.currentUser = this.authenticationService.currentUserValue;
    }

    ngOnInit() {
        this.getCourses();
    }

    getCourses() {
        this.showCourse = true;
        this.courseservice.findCourses().subscribe(courses => {
                // tslint:disable-next-line:no-string-literal
                if (courses['code'] === 200) {
                    // tslint:disable-next-line:no-string-literal
                    this.courses = courses['data'];
                    this.showCourse = false;
                }
            },
            error => {
                this.alertService.error(error);
                this.showCourse = false;
            });
    }

    disCourseDialog(id: number) {

        const dialogConfig = new MatDialogConfig();

        dialogConfig.disableClose = true;
        dialogConfig.autoFocus = true;
        dialogConfig.width = '500px';

        dialogConfig.data = {
            courseid: id
        };

        this.dialog.open(DisableCourseComponent,
            dialogConfig);

    }

}
