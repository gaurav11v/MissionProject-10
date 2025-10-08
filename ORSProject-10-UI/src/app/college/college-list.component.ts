import { Component } from '@angular/core';
import { BaseListCtl } from '../base-list.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-college-list',
  templateUrl: './college-list.component.html',
 
})
export class CollegeListComponent extends BaseListCtl{

  constructor(public locator:ServiceLocatorService, route:ActivatedRoute){
    super(locator.endpoints.COLLEGE, locator, route);
  }

}
