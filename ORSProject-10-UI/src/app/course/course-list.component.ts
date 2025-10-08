import { Component } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  
})
export class CourseListComponent extends BaseListCtl{

  constructor(public locator:ServiceLocatorService, route:ActivatedRoute){
    super(locator.endpoints.COURSE, locator, route);
  }

}
