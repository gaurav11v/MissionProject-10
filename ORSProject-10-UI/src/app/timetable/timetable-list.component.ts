import { Component } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-timetable-list',
  templateUrl: './timetable-list.component.html',
  
})
export class TimetableListComponent extends BaseListCtl{

  constructor(public locator:ServiceLocatorService, route:ActivatedRoute){
    super(locator.endpoints.TIMETABLE, locator, route);
  }

}
