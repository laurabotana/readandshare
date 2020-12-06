<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<section>
			<div class="embed-responsive embed-responsive-1by1">
				<iframe class="embed-responsive-item"
					src="https://www.openstreetmap.org/export/embed.html?bbox=-8.423037528991701%2C43.346340936566776%2C-8.390164375305178%2C43.36412734793574&amp;layer=mapnik"></iframe>
			</div>
		</section>
	</tiles:putAttribute>
</tiles:insertDefinition>