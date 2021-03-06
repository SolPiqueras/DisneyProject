package ar.solPiqueras.disney.domain.testimonials;

import java.util.List;

public interface TestimonialGateway {
    public Testimonial create(Testimonial testimonial);
    public Testimonial update(Long id, Testimonial testimonial);
    public void delete(Long id);
    public List<Testimonial> listByPage(int page, int size);
}
