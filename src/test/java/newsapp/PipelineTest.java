package newsapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.news.newsapp.entity.Headline;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class PipelineTest implements Pipeline{

	@Override
	public void process(ResultItems resultItems, Task task) {
		List<Headline> list = resultItems.get("list");
		for (Headline headline : list) {
			System.out.println(headline);
		}
	}
	


}
