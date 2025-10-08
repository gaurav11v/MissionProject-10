import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-timetable',
  templateUrl: './timetable.component.html',
  
})
export class TimetableComponent extends BaseCtl{

  constructor(public locator: ServiceLocatorService, route: ActivatedRoute){
    super(locator.endpoints.TIMETABLE, locator, route);
  }

}
