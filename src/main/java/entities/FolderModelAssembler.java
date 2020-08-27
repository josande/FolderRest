package entities;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
class FolderModelAssembler implements RepresentationModelAssembler<Folder, EntityModel<Folder>> {

    @Override
    public EntityModel<Folder> toModel(Folder folder) {

        return EntityModel.of(folder, //
                linkTo(methodOn(FolderController.class).one(folder.getId())).withSelfRel(),
                linkTo(methodOn(FolderController.class).all()).withRel("folders"));
    }
}